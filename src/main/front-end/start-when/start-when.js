const API_BASE_URL = "http://localhost:8080/weeks"

// remove any old weeks associated with this user
async function removeOldWeek(userid){
    let xhr = new XMLHttpRequest();
    xhr.open("POST", API_BASE_URL + "/remove/" + userid, true);
    xhr.send();
}


// post request instantiating a weekSer with startDate
async function addNewWeek(userid, startDate){
    let xhr = new XMLHttpRequest();
    xhr.open("POST", API_BASE_URL, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        "userId": userid,
        "startDate": startDate
    }));
}

// get request getting that weekSer
async function getNewWeek(userid){
    return fetch(API_BASE_URL + "/" + userid)
        .then(response => response.json())
        .catch(error => console.log(error));
}

// remove old week, add in new week on given start date, and save that new week as a POJO in localstorage
async function instantiateWeek(){
    const userid = localStorage.getItem("userid");
    const startDate = document.getElementById("create").value;
    await removeOldWeek(userid);
    await addNewWeek(userid, startDate);
    const weekSerRaw = await getNewWeek(userid);
    const weekSer = JSON.stringify(weekSerRaw);
    localStorage.setItem("weekSer", weekSer);
    location.href = "../timetable/timetable-empty.html";
}