module hope.common.provider2.pre.api {
	requires transitive hope.common.provider.pre.api;
	requires transitive hope.common.provider.conn.api;
	requires hope.common.data2.api;
	exports com.nabiki.hope.common.provider.pre2;
}