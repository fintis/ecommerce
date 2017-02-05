lazy val ecommerce =
  project
    .in(file("."))
    .aggregate(customers, fulfillment, inventory, `order-tracking`, payment, `product-catalog`,
      receiving, shipping, shoppingcart, orchestrator)

lazy val clientactorsSettings = Seq(
  scalaVersion := Version.scala,
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaHttp,
    Library.akkaSlf4j,
    Library.akkaStreamKafka,
    Library.logbackClassic,
    Library.akkaHttpCirce,
    Library.circeCore,
    Library.circeGeneric,
    Library.circeParser,
    Library.circeJava8
  )
)

lazy val `client-actors` = project.in(file("client-actors")).settings(clientactorsSettings)


lazy val customersSettings = Seq(
  scalaVersion := Version.scala,
  mainClass in Global := Some("com.ecommerce.customers.Boot"),
  assemblyJarName in assembly := "customers.jar",
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaHttp,
    Library.akkaHttpCirce
  )
)

lazy val customers = project.in(file("customers")).settings(customersSettings)


lazy val fulfillmentSettings = Seq(
  scalaVersion := Version.scala,
  mainClass in Global := Some("com.ecommerce.fulfillment.Boot"),
  assemblyJarName in assembly := "fulfillment.jar",
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaHttp,
    Library.akkaHttpCirce
  )
)

lazy val fulfillment = project.in(file("fulfillment")).settings(fulfillmentSettings)


lazy val inventorySettings = Seq(
  scalaVersion := Version.scala,
  assemblyJarName in assembly := "inventory.jar",
  resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype snapshots"  at "http://oss.sonatype.org/content/repositories/snapshots/"),
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaCluster,
    Library.akkaClusterSharding,
    Library.akkaClusterTools,
    Library.akkaPersistence,
    Library.akkaHttp,
    Library.akkaSlf4j,
    Library.commonsIO,
    Library.logbackClassic,
    Library.akkaHttpCirce,
    Library.circeCore,
    Library.circeGeneric,
    Library.circeParser,
    Library.circeJava8,
    Library.leveldb,
    Library.leveldbJni,
    Library.scalaTest % "test"
  )
)

lazy val inventory = project.in(file("inventory")).settings(inventorySettings)


lazy val orderTrackingSettings = Seq(
  scalaVersion := Version.scala,
  mainClass in Global := Some("com.ecommerce.ordertracking.Boot"),
  assemblyJarName in assembly := "ordertracking.jar",
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaCluster,
    Library.akkaClusterSharding,
    Library.akkaClusterTools,
    Library.akkaPersistence,
    Library.akkaHttp,
    Library.akkaHttpCirce,
    Library.circeCore,
    Library.circeGeneric,
    Library.circeParser,
    Library.circeJava8
  )
)

lazy val `order-tracking` = project.in(file("order-tracking")).settings(orderTrackingSettings)


lazy val paymentSettings = Seq(
  scalaVersion := Version.scala,
  mainClass in Global := Some("com.ecommerce.payment.Boot"),
  assemblyJarName in assembly := "payment.jar",
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaHttp,
    Library.akkaHttpCirce,
    Library.circeCore,
    Library.circeGeneric,
    Library.circeParser,
    Library.circeJava8
  )
)

lazy val payment = project.in(file("payment")).settings(paymentSettings)


lazy val productcatalogSettings = Seq(
  scalaVersion := Version.scala,
  mainClass in Global := Some("com.ecommerce.productcatalog.Boot"),
  assemblyJarName in assembly := "productcatalog.jar",
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaHttp,
    Library.akkaHttpCirce
  )
)

lazy val `product-catalog` = project.in(file("product-catalog")).settings(productcatalogSettings)


lazy val receivingSettings = Seq(
  scalaVersion := Version.scala,
  mainClass in Global := Some("com.ecommerce.receiving.Boot"),
  assemblyJarName in assembly := "receiving.jar",
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaHttp,
    Library.akkaHttpCirce,
    Library.circeCore,
    Library.circeGeneric,
    Library.circeParser,
    Library.circeJava8
  )
)

lazy val receiving = project.in(file("receiving")).settings(receivingSettings)


lazy val shippingSettings = Seq(
  scalaVersion := Version.scala,
  mainClass in Global := Some("com.ecommerce.shipping.Boot"),
  assemblyJarName in assembly := "shipping.jar",
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaHttp,
    Library.akkaHttpCirce,
    Library.circeCore,
    Library.circeGeneric,
    Library.circeParser,
    Library.circeJava8
  )
)

lazy val shipping = project.in(file("shipping")).settings(shippingSettings)


lazy val shoppingcartSettings = Seq(
  scalaVersion := Version.scala,
  mainClass in Global := Some("com.ecommerce.shoppingcart.Boot"),
  assemblyJarName in assembly := "shoppingcart.jar",
  resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype snapshots"  at "http://oss.sonatype.org/content/repositories/snapshots/"),
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaCluster,
    Library.akkaClusterSharding,
    Library.akkaClusterTools,
    Library.akkaPersistence,
    Library.akkaHttp,
    Library.akkaSlf4j,
    Library.commonsIO,
    Library.logbackClassic,
    Library.akkaHttpCirce,
    Library.circeCore,
    Library.circeGeneric,
    Library.circeParser,
    Library.circeJava8,
    Library.leveldb,
    Library.leveldbJni,
    Library.scalaTest % "test",
    Library.akkaTestKit % "test"
  )
)

lazy val shoppingcart = project.in(file("shoppingcart")).settings(shoppingcartSettings)


lazy val orchestratorSettings = Seq(
  scalaVersion := Version.scala,
  mainClass in Global := Some("com.ecommerce.orchestrator.Boot"),
  assemblyJarName in assembly := "orchestrator.jar",
  resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype snapshots"  at "http://oss.sonatype.org/content/repositories/snapshots/"),
  libraryDependencies ++= Seq(
    Library.akkaActor,
    Library.akkaHttp,
    Library.akkaSlf4j,
    Library.akkaHttpCirce,
    Library.circeCore,
    Library.circeGeneric,
    Library.circeParser,
    Library.circeJava8,
    Library.jodaTime,
    Library.cats
  )
)

lazy val orchestrator = project.in(file("orchestrator")).settings(orchestratorSettings).dependsOn(`client-actors`)


lazy val ui = project.in(file("ui")).enablePlugins(PlayScala)