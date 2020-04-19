package com.nabiki.hope.common.provider.datarw;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import com.nabiki.hope.common.data2.InternalAccount;

public interface InternalAccountRw {
	InternalAccount[] read(File f, Charset c) throws IOException;
	
	void write(File f, Charset c, Boolean append, InternalAccount... p) throws IOException;
}
