package com.nabiki.hope.common.provider.csv;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import com.nabiki.hope.common.data2.InternalNewOrder;

public interface InternalNewOrderRw {
	InternalNewOrder[] read(File f, Charset c) throws IOException;
	
	void write(File f, Charset c, Boolean append, InternalNewOrder... p) throws IOException;
}
