package com.korkutkose.couchbasedemo.persistence;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.stereotype.Repository;

/**
 * @author mehmetkorkut
 * created 28.12.2023 08:51
 * package - com.korkutkose.couchbasedemo.nosql
 * project - couchbase-demo
 */
@Repository
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface DocumentRepository extends CouchbaseRepository<DemoDocument, String>, DynamicProxyable<DocumentRepository> {

}
