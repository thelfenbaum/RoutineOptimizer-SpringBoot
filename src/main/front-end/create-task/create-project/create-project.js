const API_BASE_URL = "http://localhost:8080/project/"

let triedProjectName = document.getElementById("project_name").value;
let myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

let raw = JSON.stringify({
    "project_name": triedProjectName,
    "start_date_time": document.getElementById("start_date_time").value,
    "duration": document.getElementById("duration").value,
    "is_complete": document.getElementById("is_complete").value,
    "user_id": document.getElementById("user_id").value
});

let requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
};