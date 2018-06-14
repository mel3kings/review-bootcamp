var person = {
    firstname: 'Mel',
    lastname: 'Tatlonghari',
    greet: function(){
        console.log('Hello , ' + this.firstname + ' ' +
        this.lastname)
    }
};

person.greet();
console.log(person['firstname']);


function Worker(firstname, lastname){
    this.firstname = firstname;
    this.lastname = lastname;
}

Worker.prototype.job = function(job) {
    this.job = job
    console.log(this.firstname + ' occupation is : '
        + this.job);
};

(function(){
    console.log('IIEF')
})();


var john = new Worker('John', 'Doe');
john.job('Tradie');
console.log(john['job'])

