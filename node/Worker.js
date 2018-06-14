function doWork(){
    console.log("doing work");
}

var data = "Some database data";
module.exports = {
    doWork: doWork,
    data : data
};