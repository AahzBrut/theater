package com.aahzbrut.theater.mapper

interface Mapper<T, S> {

    fun from(source: S) : T
    fun from(sources: List<S>) : List<T> = sources.map{ s -> from(s) }
}

