package com.algorithms;

interface Dict <T extends Comparable<T>>
{
    boolean search(T data);
    void insert(T data);
    void remove(T data);
    T min();
    T max();
}