package com.example.server;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class MyApplication extends Application {
    // The class is intentionally left blank as it serves as a configuration class for JAX-RS.
}