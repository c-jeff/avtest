const assistant = document.getElementById("assistant");

assistant.addEventListener("mousedown", () => {
  assistant.style.backgroundColor = "#87e087";
  console.log('hola')
});

assistant.addEventListener("mouseup", () => {
  assistant.style.backgroundColor = "transparent";
});
