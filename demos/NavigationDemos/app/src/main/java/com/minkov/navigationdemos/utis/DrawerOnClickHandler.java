package com.minkov.navigationdemos.utis;

public interface DrawerOnClickHandler<T1, T2, T3, R> {
    R call(T1 t1, T2 t2, T3 t3);
}
