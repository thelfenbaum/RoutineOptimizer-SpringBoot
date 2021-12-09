const API_BASE_URL = "http://localhost:8080"

async function saveFixedTask(name, startDateTime, duration, userid){
    let xhr = new XMLHttpRequest();
    xhr.open("POST", API_BASE_URL + "/tasks", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        "name": name,
        "startDateTime": startDateTime,
        "duration": duration,
        "userId": userid,
        "isComplete": false
    }));
}

async function getTaskSers(userid) {
    return fetch(API_BASE_URL + "/tasks/" + userid)
        .then(response => response.json())
}

async function goToUpdatedWeek(userid) {
    localStorage.setItem("taskSers", await getTaskSers(userid));
    location.href = "../../timetable/timetable-empty.html";
}

async function submitInfo(){
    const userid = localStorage.getItem("userid")
    const name = document.getElementById("name").value;
    const duration = document.getElementById("duration").value;
    const startDateTime = document.getElementById("startDateTime").value;
    await saveFixedTask(name, startDateTime, duration, userid);
    await goToUpdatedWeek(userid);
}
