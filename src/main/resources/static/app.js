var stompClient = null;
var sessionMessage = [];
var c =1;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#send").prop("disabled",!connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
         
        $("#msg").show();
       
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
	
	$.ajax({
	    url: 'http://localhost:8091',
	    type: 'post',
	    data: {},
	  /*  headers: {
	        "Authorization": "Bearer "+jwtToken,   //key word **Bearer**  should pass before the token string
	    },*/
	    dataType: 'json',
	    success: function (data) {
	        console.info(data);
	    }
	});
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
        	//sessionStorage.setItem("oldmsg",JSON.parse(greeting.body).content);
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
	//session.local
	
	//sessionStorage.setItem( $("#name").val(), $("#msg").val());
	
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(),"msg" : $("#msg").val()  }));
    //sessionMessage.append($("#msg").val());
}

function showGreeting(message) {
	//l = message
	rt=["red","orange","blue","grren","yellow"];
	const l =message.split(" ");
	//$("#greetings").append("<tr><td>" + sessionStorage.getItem($("#name").val()) + "</td></tr>");
    $("#greetings").append("<tr><td >  <span class='badge badge-secondary user-avatar-circle' style='color':'`$rt[1]`'  >  "  +l[0][0] +" </span>"   + message + " </td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName();      });
});