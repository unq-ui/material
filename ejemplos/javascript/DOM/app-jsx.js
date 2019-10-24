/**
<div>
<h1 id="title-js">Bienvenidos al <em>DOM</em></h1>
<h2>Notas</h2>
<div style="background-color: lightskyblue; padding: 5px; width: 150px;">
    <input name="new-note" id="new-note"/>
    <button onclick="addNote()">Agregar</button>
</div>
<p>Nota 1 | <button onclick="(event) => ..."></p>
</div>
*/
const addCurrentNote = () => {
    let input = document.querySelector("#new-note");
    let text = input.value;
    let p = document.createElement("p");
    let btn = document.createElement("button");
    btn.textContent = "Eliminar";
    btn.onclick = (event) => event.target.parentNode.remove();
    p.textContent = text;
    p.appendChild(btn);
    document.getElementById('container').appendChild(p);
    input.value = "";
}

const app = <div id="container">
    <h1 id="title-js">Bienvenido a <em>React-DOM con JSX</em></h1>
    <h2>Notas</h2>
    <div className="fooDiv">
        <input id="new-note"/>
        <button onClick={addCurrentNote}>Agregar</button>
    </div>
</div>;

ReactDOM.render(app, document.getElementById("app"));
