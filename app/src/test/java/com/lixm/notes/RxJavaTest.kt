package com.lixm.notes

import org.junit.Test

class RxJavaTest {
    @Test
    fun test() {
        //RxJava
//        Flowable.range(1,10)
//            .observeOn(Schedulers.computation())//Schedulers.computation() 密集计算操作，大多数异步操作该调度
//            .map {
//                it * it
//            }.blockingSubscribe(System.out:: println)

        //skip 跳过
//        var source : Observable<Int> = Observable.just(1,2,3,4,5,6,7,8,9,10);
//        source.skip(4)
//            .subscribe(System.out::print)
        //跳过后4个
//        source.skipLast(4)
//            .subscribe(System.out::print)


        //
//        var source = Observable.create<String>{emitter ->
//            emitter.onNext("A")
//
//            Thread.sleep(1500)
//            emitter.onNext("B")
//
//            Thread.sleep(500)
//            emitter.onNext("C")
//
//            Thread.sleep(250)
//            emitter.onNext("D")
//
//            Thread.sleep(2000)
//            emitter.onNext("E")
//            emitter.onComplete()
//
//        }
//        source.subscribeOn(Schedulers.io())
//            .debounce(1, TimeUnit.SECONDS)
//            .blockingSubscribe(Consumer <String>{item-> print(item+"") },
//                Consumer<Throwable>{t ->t.printStackTrace()},
//                Action { System.out.println("onComplete") })


//        Observable.just(2,3,4,4,2,1)
////            .distinct()//去重
//            .distinctUntilChanged()//去掉相邻重复数据
//            .subscribe(System.out::println)

        //获取指定位置元素
//        Observable.just(2,4,3,1,5,8)
//            .elementAt(0)
//            .subscribe { integer -> print("elmentAt ->$integer") }

//        var source : Observable<String> = Observable.just("Kirk","Spock","Chekov","Sulu");
//        var element : Single<String> = source.elementAtOrError(4)
//        element.subscribe(
//            Consumer<String> {name -> System.out.println("onSuccess will not be printed!")  },
//            Consumer<Throwable>{error -> System.out.println("onError:$error")})

        //过滤
//        Observable.just(1,2,3,4,5,6)
//            .filter{x -> x % 2 == 0}//false 表示过滤该数据
//            .subscribe(System.out::println)

        //第一个
//        var source : Observable<String> = Observable.just("A","B","C")
//        var firstOrDefault : Single<String> = source.first("D")
//        firstOrDefault.subscribe{x->System.out.println(x)}

//        var emptySource : Observable<String> = Observable.empty()
//        var firstOrError : Single<String> = emptySource.firstOrError()
//        firstOrError.subscribe(
//            Consumer { element -> System.out.println("onSuccess will not be printed!") },
//            Consumer { error -> System.out.println("onError: + $error") }
//        )

        //last(最后一个)
//        var source : Observable<String> = Observable.just("A","B","C")
//        var lastOrDefault : Single<String> = source.last("D")
//        lastOrDefault.subscribe(Consumer{element -> System.out.println(element)})

//        var source : Observable<String> = Observable.just("A","B","C","D")
//        var last :Maybe<String> = source.lastElement()
//        last.subscribe{emlemt -> System.out.println(emlemt)}

//        var emptySource : Observable<String> = Observable.empty()
//        var lastOrError : Single<String> = emptySource.lastOrError()
//        lastOrError.subscribe(
//            {element -> System.out.println("onSuccess will not be printed!")},
//            {error -> System.out.println("onError: + $error")}
//        )

        //ignoreElements ignoreElement (忽略元素)
//        var source : Single<Long> = Single.timer(1,TimeUnit.SECONDS)
//        var completable : Completable = source.ignoreElement()
//        completable.doOnComplete{System.out.println("Done!")}.blockingAwait()

//        var source : Observable<Long> = Observable.intervalRange(1,5,1,1,TimeUnit.SECONDS)
//        var completable : Completable = source.ignoreElements()
//        completable.doOnComplete{ println("Done!")}.blockingAwait()

        //ofType 过滤掉类型
//        var numbers : Observable<Number> = Observable.just(1,4.0,3,2.71,2f,7)
//        var integers : Observable<Int> = numbers.ofType(Int::class.javaObjectType)//java中Integer.class 写法 对应kotlin写法 Int::class.javaObjectType
//        integers.subscribe{x -> println("===$x")}

        //sample
//        var source : Observable<String> = Observable.create { emitter ->
//            emitter.onNext("A")
//
//            Thread.sleep(500)
//            emitter.onNext("B")
//
//            Thread.sleep(200)
//            emitter.onNext("C")
//
//            Thread.sleep(800)
//            emitter.onNext("D")
//
//            Thread.sleep(600)
//            emitter.onNext("E")
//            emitter.onComplete()
//        }
//        source.subscribeOn(Schedulers.io())
//            .sample(1,TimeUnit.SECONDS)
//            .blockingSubscribe(
//                {item -> print(item+" ")},
//                {error -> error.printStackTrace()},
//                { println("onComplete")}
//            )

        //throttleFirst throttleLast throttleWithTimeout
//        var source : Observable<String> = Observable.create { emitter ->
//            emitter.onNext("A")
//
//            Thread.sleep(500)
//            emitter.onNext("B")
//
//            Thread.sleep(200)
//            emitter.onNext("C")
//
//            Thread.sleep(800)
//            emitter.onNext("D")
//
//            Thread.sleep(600)
//            emitter.onNext("E")
//            emitter.onComplete()
//
//        }
//        source.subscribeOn(Schedulers.io())
//            .throttleFirst(1, TimeUnit.SECONDS)//周期内第一个元素
//            .blockingSubscribe(
//                {item -> print(item+" ")},
//                {error -> error.printStackTrace()},
//                { println("onComplete")}
//            )

//        source.subscribeOn(Schedulers.io())
//            .throttleLast(1,TimeUnit.SECONDS)//周期内最后一个元素
//            .blockingSubscribe(
//                {item -> print(item+" ")},
//                {error -> error.printStackTrace()},
//                { println("onComplete")}
//            )
//
        //
//        source.subscribeOn(Schedulers.io())
//            .throttleLatest(1,TimeUnit.SECONDS)
//            .blockingSubscribe(
//                {item -> print(item+" ")},
//                {error -> error.printStackTrace()},
//                { println("onComplete")}
//            )

        //take takeLast
//        var source : Observable<Int> = Observable.just(1,2,3,4,5,6,7,8,9,10)
//        source.take(4)//发射前4个
//            .subscribe(System.out::println)
//
//        source.takeLast(4)
//            .subscribe(System.out::println)

        //timeout 超时
//        var source : Observable<String> = Observable.create{emitter ->
//            emitter.onNext("A")
//
//            Thread.sleep(800)
//            emitter.onNext("B")
//
//            Thread.sleep(400)
//            emitter.onNext("C")
//
//            Thread.sleep(1200)
//            emitter.onNext("D")
//            emitter.onComplete()
//        }
//        source.timeout(1,TimeUnit.SECONDS)//不能再1s之内，发射一个元素，就会执行error方法
//            .subscribe(
//                {item -> System.out.println("onNext:$item")},
//                { error -> println("onError: $error")},
//                { println("onComplete will not be printed!")}
//            )

        //strartWith
//        var names : Observable<String> = Observable.just("Spock","McCoy")
//        var otherNames = Observable.just("Git","Code","8")
////        names.startWith(otherNames).subscribe(System.out::println)
//        otherNames.startWith(names).subscribe(System.out::println)//names合并在otherNames头

        //merge
//        var name : Observable<String> = Observable.just("Hello","world")
//        var otherName : Observable<String> = Observable.just("Git","Code","8")
//        var error : Observable<String> = Observable.error{NullPointerException("Error")}
////        Observable.merge(name,otherName).subscribe{name -> println(name)}
////        Observable.merge(otherName,name).subscribe { name -> println(name) }
//        Observable.mergeDelayError(name,error,otherName).subscribe { name -> println(name) }

        //zip
//        var name = Observable.just("Hello", "world")
//        var otherNames = Observable.just("Git", "Code", "8")
//        name.zipWith(ObservableSource<String> { otherNames },{zipper:()}).subscribe (
//            {item -> println(item)},
//            { error -> error.printStackTrace()},
//            { print("onComplete")}
//        )

//        Observable.range(0,10)
//            .buffer(4)
//            .subscribe{buffer ->
//                println(buffer)
//            }

        //cast
//        var numbers : Observable<Number> = Observable.just(1,4.0,3f,7,12,4.6,5)
//        numbers.filter{ x -> Int::class.javaObjectType.isInstance(x)}
//            .cast(Int::class.javaObjectType)
//            .subscribe{x -> System.out.println(x)}

        //concatMap
//        Observable.range(0,5)
//            .concatMap { i ->//concatMap 将函数的返回值有序的存在新的数据源
//                var delay = Math.round(Math.random() * 2)
//                return@concatMap Observable.timer(delay,TimeUnit.SECONDS).map { n ->i}
//            }
//            .blockingSubscribe(System.out::println)
//
//        Observable.just("A", "B", "C")
//            .flatMap { a ->
//                return@flatMap Observable.intervalRange(1, 2, 0, 1, TimeUnit.SECONDS)
//                    .map { b -> "($a,$b)" }
//            }
//            .blockingSubscribe(System.out::println)

    }
}