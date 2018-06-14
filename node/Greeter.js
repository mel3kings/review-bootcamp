function greet() {
    console.log('hi');
}
function logGreeting(fn) {
    fn();
}
logGreeting(greet);

var greetMe = function () {
    console.log('hello again!')
}
greetMe()

module.exports = greetMe;