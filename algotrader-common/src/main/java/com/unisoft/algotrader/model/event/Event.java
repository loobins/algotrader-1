package com.unisoft.algotrader.model.event;

/**
 * Created by alex on 4/12/15.
 */
public interface Event<T extends EventHandler, E extends Event<T, ?>> {
    public void on(T handler);
}
