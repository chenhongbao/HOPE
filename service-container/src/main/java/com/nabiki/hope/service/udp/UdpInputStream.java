package com.nabiki.hope.service.udp;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpInputStream extends InputStream {
    // UDP server socket.
    private final DatagramSocket udp;
    private final DatagramPacket packet;

    // Maximum safe UDP body size.
    private int bufSize = 508;

    // Mark the next byte available for reading.
    private int mark = 0;

    private byte[] buffer;
    private int actualRecvSize = 0;

    public UdpInputStream(int port, InetAddress address) throws SocketException {
        this.buffer = new byte[this.bufSize];
        this.udp = new DatagramSocket(port, address);
        this.packet = new DatagramPacket(this.buffer, this.buffer.length);
    }

    @Override
    public int read() throws IOException {
        // Stream has been closed, can't read.
        if (this.mark == -1) {
            throw new IOException("UDP input stream has been closed and it is unreadable.");
        }

        // If all data in buffer has been read, receive the next packet.
        if (this.mark >= this.actualRecvSize) {
            this.mark = 0;
            this.udp.receive(this.packet);
            this.actualRecvSize = this.packet.getLength();
        }

        return (int)this.buffer[this.mark++];
    }

    @Override
    public int available() throws IOException {
        return this.actualRecvSize - this.mark;
    }

    @Override
    public void close() throws IOException {
        if (!this.udp.isClosed())
            this.udp.close();

        this.mark = -1;
        this.actualRecvSize = 0;
    }
}
