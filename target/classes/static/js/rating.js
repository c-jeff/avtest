var talking = document.getElementById('talking-content');
var message = document.getElementById('recording');
var talking_border = document.getElementById('talking-border')

talking.onclick = function() {
  message.style.display = 'block';
  talking.style.backgroundColor = 'red';
  talking_border.style.borderColor = 'red';
  setTimeout(function() {
    talking.style.backgroundColor = 'transparent';
    talking_border.style.borderColor = '#33cc33';
    message.style.display = 'none';
  }, 5000);
}