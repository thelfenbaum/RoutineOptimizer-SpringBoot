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

Date.prototype.addDays = function(days) {
    let date = new Date(this.valueOf());
    date.setDate(date.getDate() + days);
    return date;
}

Date.prototype.addMinutes = function(minutes) {
    let date = new Date(this.valueOf());
    date.setTime(date.getTime() + minutes*60000);
    return date;
}

Date.prototype.addHours = function(hours) {
    let date = new Date(this.valueOf());
    date.setTime(date.getTime() + hours*60*60*1000);
    return date;
}

Date.prototype.getHoursFormatted = function() {
    let hours = this.getHours();
    if (hours >= 10) {
        return hours.toString();
    } else {
        return "0" + hours.toString();
    }
}

Date.prototype.getMinutesFormatted = function() {
    let minutes = this.getMinutes();
    if (minutes === 30) {
        return minutes.toString();
    } else {
        return "00";
    }
}

Date.prototype.getTimeFormatted = function() {
    return this.getHoursFormatted + ":" + this.getMinutesFormatted();
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
                <div class="cd-schedule__top-info"><span>${getWeekDay(startDate.addDays(i).getDay())},
                ${startDate.addDays(i).getDate()+1}-${startDate.addDays(i).getMonth()+1}-${startDate.addDays(i).getFullYear()}</span></div>
                <ul id="day-${startDate.addDays(i).getDay()}">
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
    const endDateTime = startDateTime.addHours(duration.slice(0, 2)).addMinutes(duration.slice(3, 5))
    const day = startDateTime.getDay();
    taskNode +=
        `<li class="cd-schedule__event">
            <a data-start="${startDateTime.getTimeFormatted()}" data-end="${endDateTime.getTimeFormatted()}" 
            data-content="${taskSerJSON.name}" data-event="event-${taskSerJSON.id}" href="#0">
                <em class="cd-schedule__name">${taskSerJSON.name}</em>
            </a>
        </li>`
    document.querySelector("#" + day).innerHTML = taskNode;
}

function updateTasksOnDOM(taskSerJSONArray){
    for (let i = 0; i < taskSerJSONArray.length; i++) {
        updateTaskOnDOM(JSON.parse(taskSerJSONArray[i]));
    }
}

function instantiateDOM(weekSerJSON, taskSerJSONArray){
    createWeekOnDOM(weekSerJSON);
    updateTasksOnDOM(taskSerJSONArray);
}


instantiateDOM(JSON.parse(localStorage.getItem("weekSer")), localStorage.getItem("taskSers"));