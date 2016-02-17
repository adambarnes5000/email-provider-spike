package com.mttnow.email.provider.spike.converters


interface Converter<F,T> {

  T convert(F from)

}