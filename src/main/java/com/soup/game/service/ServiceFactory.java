package com.soup.game.service;

import com.soup.game.intf.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple service registry for managing instances of services.
 *
 * <p>Allows registering service instances by type and retrieving them
 * later using their class type. Useful for dependency management
 * within the game.</p>
 */
@SuppressWarnings("all")
public class ServiceFactory {
    private final Map<Class<? extends Service>, Service> services = new LinkedHashMap<>();

    /**
     * Registers a service instance with its class type.
     *
     * <p>If a service of the same type was previously registered, it
     * will be replaced by the new instance.</p>
     *
     * @param type     the class type of the service
     * @param instance the service instance to register
     * @param <T>      the type of the service
     */
    public <T extends Service> void register(Class<T> type, T instance) {
        services.put(type, instance);
    }

    /**
     * Retrieves a previously registered service instance by type.
     *
     * @param type the class type of the service to retrieve
     * @param <T>  the type of the service
     * @return the registered service instance, or null if not registered
     */
    public <T extends Service> T get(Class<T> type) {
        return type.cast(services.get(type));
    }
}