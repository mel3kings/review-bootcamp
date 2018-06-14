var Emitter = require('events');
var emtr = new Emitter();
var events = {
    TEST: 'test',
    SAVE: 'save',
    EXIT: 'exit'
};

emtr.on(events.SAVE, function(){
    console.log('Event saved');
});

emtr.on(events.exit, function(){
    console.log("Event exit");
});

emtr.on(events.TEST, function(){
    console.log('code testing');
});

emtr.emit(events.SAVE);
emtr.emit(events.TEST);
emtr.emit(events.EXIT);