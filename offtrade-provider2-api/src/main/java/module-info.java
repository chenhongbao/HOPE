module hope.common.provider.off2.api {
	requires transitive hope.common.provider.off.api;
	requires transitive hope.common.provider.conn.api;
	requires hope.common.data2.api;
	exports com.nabiki.hope.common.provider.off2;
}