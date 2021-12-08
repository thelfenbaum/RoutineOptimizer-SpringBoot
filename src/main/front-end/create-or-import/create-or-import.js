API_BASE_URL = "http://localhost:8080/"

// let triedUserId = document.getElementById("user_id").value;
//
// let myHeaders = new Headers();
// myHeaders.append("Content-Type", "application/json");
//
// let raw = JSON.stringify({
//     "user_id": triedUserId,
//     "start_date": document.getElementById("start_date").value
//
// });
//
// let requestOptions = {
//     method: 'POST',
//     headers: myHeaders,
//     body: raw,
//     redirect: 'follow'
// };

async function getWeekStartDate(userid) {
    return fetch(API_BASE_URL + "weeks/" + userid)
        .then(response => response.json())
        .then(week => week.start_date)
        .catch(error => console.log(error));
}

async function getTaskName(id) {
    return fetch(API_BASE_URL + "tasks/" + id)
        .then(response => response.json())
        .then(task => task.name)
        .catch(error => console.log(error));
}

async function getTaskStartDateTime(id){}

async function getTaskDuration(id){}

async function getTaskIsComplete(id){}

async function getAllTasks(userid){}

async function importWeek() {
    localStorage.setItem("weekStartDate", await getWeekStartDate(localStorage.getItem("userid")));
    localStorage.setItem("taskSers", await getTaskSers(localStorage.getItem("userid")));
    location.href = "../timetable/timetable-empty.html";
}

function createWeek() {

}

