/**
<h1 id="title-js">Bienvenidos al <em>DOM</em></h1>
<h2>Notas</h2>
<div style="background-color: lightskyblue; padding: 5px; width: 150px;">
    <input name="new-note" id="new-note"/>
    <button onclick="addNote()">Agregar</button>
</div>
<p>Nota 1 | <button onclick="(event) => ..."></p>
*/
const h1 = document.createElement('h1');
const h2 = document.createElement('h2');
const em = document.createElement('em');
const div = document.createElement('div');
const input = document.createElement('input');
const btn = document.createElement('button');

h1.setAttribute('id', 'title-js');
h1.textContent = "Bienvenidos al ";
em.textContent = "DOM";
h2.textContent = "Notas";
div.setAttribute('style', "background-color: lightskyblue; padding: 5px; width: 320px;");
btn.textContent = "Agregar";

h1.appendChild(em);
div.appendChild(input);
div.appendChild(btn);

input.setAttribute('id', 'new-note');
btn.onclick = () => {
    let text = document.getElementById("new-note").value;
    let p = document.createElement("p");
    let btn = document.createElement("button");
    btn.textContent = "Eliminar";
    btn.onclick = (event) => event.target.parentNode.remove();
    p.innerHTML = text;
    p.appendChild(btn);
    document.getElementById('app').appendChild(p);
    document.getElementById("new-note").value = "";
}

document.getElementById('app').appendChild(h1);
document.getElementById('app').appendChild(h2);
document.getElementById('app').appendChild(div);
