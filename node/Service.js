var worker = require('./Worker');
var greeter = require('./Greeter');

worker.doWork();
console.log("Now i have access to: " + worker.data);
greeter();