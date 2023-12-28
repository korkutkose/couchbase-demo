package com.korkutkose.couchbasedemo.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;

import java.time.LocalDate;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

/**
 * @author mehmetkorkut
 * created 28.12.2023 08:51
 * package - com.korkutkose.couchbasedemo.nosql
 * project - couchbase-demo
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Scope("snapshot")
@Collection("capacitySnapshot")
public class DemoDocument extends BaseDocument {
    @Id
    @GeneratedValue(strategy = UNIQUE)
    @Field(name = "ID")
    private String id;
    @Field(name = "SEASON_SNAPSHOT_ID")
    private String seasonSnapshotId;
    @Field(name = "CAPACITY_DAY")
    private LocalDate day;
}
