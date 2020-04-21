package com.nabiki.hope.service.udp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpOutputStream extends OutputStream {
    private byte[] buffer;

    // Mark the next available byte in byte array. When byte array is empty, mark is zero.
    private int mark = 0;

    // Maximum safe UDP body size.
    private int bufSize = 508;

    private final DatagramSocket udp;

    // UDP server address and port
    int port;
    InetAddress address;

    public UdpOutputStream(int port, InetAddress address) throws SocketException {
        this.buffer = new byte[this.bufSize];
        this.udp = new DatagramSocket();
    }

    @Override
    public void write(int b) throws IOException {
        // Socket is closed or no buffer, can't write.
        if (this.udp.isClosed() || this.bufSize == 0) {
            return;
        }

        if (this.mark >= this.bufSize) {
            throw new IOException("Buffer is overflow, please flush stream for each writing.");
        }

        this.buffer[this.mark++] = (byte) b;
    }

    @Override
    public void flush() throws IOException {
        // Socket is closed or no data in buffer, no need to flush.
        if (this.udp.isClosed() || this.mark == 0) {
            return;
        }

        var packet = new DatagramPacket(this.buffer, 0, this.mark, this.address, this.port);
        this.udp.send(packet);

        // Reset buffer.
        this.mark = 0;
    }

    @Override
    public void close() throws IOException {
        if (!this.udp.isClosed())
            this.udp.close();

        // Set buffer size to zero so that no more bytes can be written.
        this.bufSize = 0;
    }
}
