package com.lixm.notes.modelimport com.lixm.notes.model.factory.ShapeFactoryimport com.lixm.notes.model.factory.ab.FactoryProducerimport com.lixm.notes.model.factory.adapter.AudioPlayerimport com.lixm.notes.model.factory.appearance.ShapeMakerimport com.lixm.notes.model.factory.bridging.Circleimport com.lixm.notes.model.factory.bridging.GreenCircleimport com.lixm.notes.model.factory.bridging.RedCircleimport com.lixm.notes.model.factory.builder.MealBuilderimport com.lixm.notes.model.factory.combination.Employeeimport com.lixm.notes.model.factory.decorator.Rectangleimport com.lixm.notes.model.factory.decorator.RedShapeDecoratorimport com.lixm.notes.model.factory.filter.*import com.lixm.notes.model.factory.prototype.ShapeCacheimport com.lixm.notes.model.factory.proxy.Imageimport com.lixm.notes.model.factory.proxy.ProxyImageimport com.lixm.notes.model.factory.singleton.SingleObjectimport com.lixm.notes.model.factory.singleton.Singletonimport org.junit.Testclass FactoryPatternDemo {    /**     * 工厂模式     */    @Test    fun testFactory(){        var shapeFactory = ShapeFactory()        var circleShape = shapeFactory.getShape("CIRCLE")        circleShape?.draw()    }    @Test    fun testAbFactory(){        var factoryProducer = FactoryProducer()        var factory = factoryProducer.getFactory("SHAPE")        var circleShape = factory?.getShape("CIRCLE")        circleShape?.draw()    }    @Test    fun testSingle(){        SingleObject.instance.showMessage()        Singleton.getSingleton()?.showMsg()    }    @Test    fun testBuilder(){        var mealBuilder = MealBuilder()        var vegMeal = mealBuilder.prepareVegMeal()        vegMeal.showItems()        var nonVegMeal = mealBuilder.prepareNonVegMeal()        nonVegMeal.showItems()    }    @Test    fun testPrototype(){        ShapeCache.loadCache()        var clonedShape = ShapeCache.getShape("1")        println("Shape : " + clonedShape.type)        var clonedShape2 = ShapeCache.getShape("2")        println("Shape : " + clonedShape2.type)        val clonedShape3 = ShapeCache.getShape("3")        println("Shape : " + clonedShape3.type)    }    @Test    fun testAdapter(){        val audioPlayer = AudioPlayer()        audioPlayer.play("mp3","beyond the horizon.mp3")        audioPlayer.play("mp4","alone.mp4")        audioPlayer.play("vlc","far far away.vlc")        audioPlayer.play("avi","mind me.avi")    }    @Test    fun testBridging(){        val redCircle = Circle(100,100,100,RedCircle())        val greenCircle = Circle(100,100,10,GreenCircle())        redCircle.draw()        greenCircle.draw()    }    @Test    fun testFilter(){        var persons: ArrayList<Person> = ArrayList()        persons.add(Person("Robert","Male","Single"))        persons.add(Person("John","Male","Married"))        persons.add(Person("Laura","Female","Married"))        persons.add(Person("Diana","Female","Single"))        persons.add(Person("Mike","Male","Single"))        persons.add(Person("Bobby","Male","Single"))        var male : Criteria = CriteriaMale()        var female : Criteria = CriteriaFemale()        var single : Criteria = CriteriaSingle()        var singleMale: Criteria = AndCriteria(single,male)        var singleOrFemale = OrCriteria(single,female)        println("Males:")        printPersons(male.meetCriteria(persons))        println("Females:")        printPersons(female.meetCriteria(persons))        println("Single Males")        printPersons(singleMale.meetCriteria(persons))        println("Single Or Females:")        printPersons(singleOrFemale.meetCriteria(persons))    }    fun printPersons( persons: List<Person>?){        if(persons == null) return        for(person in persons){            println("Person:[Name:${person.name},Gender:${person.gender},Marital Status:${person.maritalStatus}")        }    }    @Test    fun testCombination(){        var CEO = Employee("John","CEO",30000)        var headSales = Employee("Robert","Head Sales",20000)        var headMarketing = Employee("Michel","Head Marketing",20000)        val clerk1 = Employee("Laura", "Marketing", 10000)        val clerk2 = Employee("Bob", "Marketing", 10000)        val salesExecutive1 = Employee("Richard", "Sales", 10000)        val salesExecutive2 = Employee("Rob", "Sales", 10000)        CEO.add(headSales)        CEO.add(headMarketing)        headSales.add(salesExecutive1)        headSales.add(salesExecutive2)        headMarketing.add(clerk1)        headMarketing.add(clerk2)        println(CEO)        for (headEmployee in CEO.subordinates!!){            println(headEmployee)            for(employee in headEmployee?.subordinates!!){                println(employee)            }        }    }    @Test    fun testDecorator(){        var circle = com.lixm.notes.model.factory.decorator.Circle()        var redCircle = RedShapeDecorator(com.lixm.notes.model.factory.decorator.Circle())        var redRectangle = RedShapeDecorator(Rectangle())        println("Circle with normal border")        circle.draw()        println("Circle of red border")        redCircle.draw()        println("Rectangle of red border")        redRectangle.draw()    }    @Test    fun testAppearance(){        var maker = ShapeMaker()        maker.drawCircle()        maker.drawRectangle()        maker.drawSquare()    }    private val colors = arrayOf("Red", "Green", "Blue", "White", "Black" )    @Test    fun testFlyWeight(){        var index = 0        while (index < 20){            var circle =                com.lixm.notes.model.factory.flyweight.ShapeFactory.getCircle(getRandomColor()) as com.lixm.notes.model.factory.flyweight.Circle            circle.x = getRandomX()            circle.y = getRandomY()            circle.radius = 100            circle.draw()            index++        }    }    private fun getRandomColor(): String {        return colors[(Math.random() * colors.size).toInt()]    }    private fun getRandomX(): Int {        return (Math.random() * 100).toInt()    }    private fun getRandomY(): Int {        return (Math.random() * 100).toInt()    }    @Test    fun testProxy(){        var image: Image = ProxyImage("test4.jpg")        image.display()        println()        image.display()    }}