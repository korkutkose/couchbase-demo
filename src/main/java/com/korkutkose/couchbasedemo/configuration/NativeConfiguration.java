package com.korkutkose.couchbasedemo.configuration;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.stereotype.Component;

/**
 * @author mehmetkorkut
 * @created 8.01.2024 16:25
 * @package - com.korkutkose.couchbasedemo
 * @project - couchbase-demo
 */
@Component
@RegisterReflectionForBinding(classes = {
        com.couchbase.client.core.deps.io.netty.channel.local.LocalAddress.class
})
public class NativeConfiguration {
}
