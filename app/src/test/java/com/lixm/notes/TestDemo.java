package com.lixm.notes;import org.junit.Test;public class TestDemo {    @Test    public void t(){//        Observable.intervalRange(1, 3, 0, 1, TimeUnit.SECONDS)//                .concatMapDelayError(x -> {//                    if (x.equals(1L)) return Observable.error(new IOException("Something went wrong!"));//                    else return Observable.just(x, x * x);//                })//                .blockingSubscribe(//                        x -> System.out.println("onNext: " + x),//                        error -> System.out.println("onError: " + error.getMessage()));    }}