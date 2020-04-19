package com.nabiki.hope.common.provider.datarw;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import com.nabiki.hope.common.data.Candle;

public interface CandleRw {
	Candle[] read(File f, Charset c) throws IOException;
	
	void write(File f, Charset c, Boolean append, Candle... p) throws IOException;
}
