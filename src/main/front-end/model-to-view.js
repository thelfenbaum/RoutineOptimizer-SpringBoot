function getWeekDay(num){
    if (num === 0){
        return "Monday"
    } else if (num === 1){
        return "Tuesday"
    } else if (num === 2){
        return "Wednesday"
    } else if (num === 3){
        return "Thursday"
    } else if (num === 4){
        return "Friday"
    } else if (num === 5){
        return "Saturday"
    } else if (num === 6){
        return "Sunday"
    }
}

function addDays(datetime, days) {
    let date = new Date(datetime.valueOf());
    date.setDate(date.getDate() + days);
    return date;
}

function addMinutes(datetime, minutes) {
    let date = new Date(datetime.valueOf());
    date.setTime(date.getTime() + minutes*60000);
    return date;
}

function addHours(datetime, hours) {
    let date = new Date(datetime.valueOf());
    date.setTime(date.getTime() + hours*60*60*1000);
    return date;
}

function getHoursFormatted(datetime) {
    let hours = datetime.getHours();
    if (hours >= 10) {
        return hours.toString();
    } else {
        return "0" + hours.toString();
    }
}

function getMinutesFormatted(datetime) {
    let minutes = datetime.getMinutes();
    if (minutes === 30) {
        return minutes.toString();
    } else {
        return "00";
    }
}

function getTimeFormatted(datetime) {
    return getHoursFormatted(datetime) + ":" + getMinutesFormatted(datetime);
}


/**
 * Create an empty week from a JSON file denoting a week.
 *
 * @param weekSerJSON: a JSON file denoting a WeekSerializable.
 */
function createWeekOnDOM(weekSerJSON){
    let weekTimetable = ``;
    const startDate = new Date(weekSerJSON.startDate);
    for(let i = 0; i <= 6; i++){
        weekTimetable +=
            `<li class="cd-schedule__group">
                <div class="cd-schedule__top-info"><span>${getWeekDay(addDays(startDate, i).getDay())},
                ${addDays(startDate, i).getDate()+1}-${addDays(startDate, i).getMonth()+1}-${addDays(startDate, i).getFullYear()}</span></div>
                <ul id="day-${addDays(startDate, i).getDay()}">
                </ul>
            </li>`
    }
    document.querySelector("#schedule__events").innerHTML = weekTimetable;
}

/**
 * Add task nodes to the DOM based on the JSON file denoting a task.
 *
 * @param taskSerJSON: a JSON file denoting a TaskSerializable
 */
function updateTaskOnDOM(taskSerJSON){
    let taskNode = ``;
    const startDateTime = new Date(taskSerJSON.startDateTime);
    const duration = taskSerJSON.duration;
    const endDateTime = addMinutes(addHours(startDateTime, duration.slice(0, 2)), duration.slice(3, 5))
    const day = startDateTime.getDay();
    taskNode +=
        `<li class="cd-schedule__event">
            <a data-start=${getTimeFormatted(startDateTime)} data-end=${getTimeFormatted(endDateTime)} 
            data-content=${taskSerJSON.name} data-event="event-1" href="#">
                <em class="cd-schedule__name">${taskSerJSON.name}</em>
            </a>
        </li>`
    document.querySelector("#day-" + day).innerHTML = taskNode;
}

function updateTasksOnDOM(taskSerJSONArray){
    for (let i = 0; i < taskSerJSONArray.length; i++) {
        updateTaskOnDOM(taskSerJSONArray[i]);
    }
}

function instantiateDOM(weekSerJSON, taskSerJSONArray){
    createWeekOnDOM(weekSerJSON);
    updateTasksOnDOM(taskSerJSONArray);
}


instantiateDOM(JSON.parse(localStorage.getItem("weekSer")), JSON.parse(localStorage.getItem("taskSers")));