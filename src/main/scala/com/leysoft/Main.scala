package com.leysoft

import interpreter.future._
import interpreter.option._
import syntax.apply._
import syntax.functor._
import syntax.applicative._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Success

object Main extends App {
  val program: Program[Option] = new Program[Option]
  val option = program
    .pure(1)
    .fmap(_ + 2)
    .ap(((x: Int) => x * 2).pure) <*> ((x: Int) => x.toString).pure
  println(option)
  val future: Future[Int] = Future.successful(1) <> (_ + 2)
  future.onComplete {
    case Success(value) => println(value)
    case _              => println("Error...")
  }
}
