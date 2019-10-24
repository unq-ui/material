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

const reactComponent = React.createElement('div', { id: 'container' },
    React.createElement('h1', { id: 'title-js' },
        "Bienvenido a ",
        React.createElement("em", null, "React-DOM")
    ),
    React.createElement("h2", null, "Notas"),
    React.createElement("div", { className: 'fooDiv' },
        React.createElement("input", { id: "new-note" }),
        React.createElement("button", {
            onClick: (event) => {
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
        }, "Agregar"),
    )
);

ReactDOM.render(reactComponent, document.getElementById("app"));
