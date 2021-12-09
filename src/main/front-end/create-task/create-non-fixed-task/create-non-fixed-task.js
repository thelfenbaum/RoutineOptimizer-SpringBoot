const API_BASE_URL = "http://localhost:8080/tasks/"

// let triedName = document.getElementById("name").value;
// let myHeaders = new Headers();
// myHeaders.append("Content-Type", "application/json");
//
// let raw = JSON.stringify({
//     "name": triedName,
//     "start_date_time": document.getElementById("start_date_time").value,
//     "duration": document.getElementById("duration").value,
//     "user_id": document.getElementById("user_id").value
// });
//
// let requestOptions = {
//     method: 'POST',
//     headers: myHeaders,
//     body: raw,
//     redirect: 'follow'
// };

async function createNonFixedTask(name, dueDateTime, duration, userid){
    let xhr = new XMLHttpRequest();
    xhr.open("POST", API_BASE_URL + "instantiate-non-fixed-task", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        "name": name,
        "dueDateTime": dueDateTime,
        "duration": duration,
        "userId": userid,
        "isComplete": false
    }));
}

// async function getWeekSer(userid) {
//     return fetch(API_BASE_URL + "weeks/" + userid)
//         .then(response => response.json())
// }

async function getTaskSers(userid) {
    return fetch(API_BASE_URL + userid)
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
    const dueDateTime = document.getElementById("dueDateTime").value;
    await createNonFixedTask(name, duration, dueDateTime, userid);
    await goToUpdatedWeek(userid);
}
