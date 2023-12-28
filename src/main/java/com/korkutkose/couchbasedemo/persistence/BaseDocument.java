package com.korkutkose.couchbasedemo.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.couchbase.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author mehmetkorkut
 * created 28.12.2023 08:52
 * package - com.korkutkose.couchbasedemo.nosql
 * project - couchbase-demo
 */
@Getter
@Setter
public abstract class BaseDocument implements Serializable {
    private static final long serialVersionUID = 1L;

    @CreatedBy
    @Field(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Field(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Field(name = "UPDATED_BY")
    private String updatedBy;

    @LastModifiedDate
    @Field(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}
