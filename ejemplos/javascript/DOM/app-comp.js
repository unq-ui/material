const Note = ({ text }) => {
    return <div>
        {text}
        <button onClick={(event) => event.target.parentNode.remove()}>Eliminar</button>
    </div>
};

class App extends React.Component {
    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            text: props.text,
            notes: props.notes || []
        };
        this.addCurrentNote = this.addCurrentNote.bind(this);
    }

    addCurrentNote() {
        this.setState({ notes: [...this.state.notes, this.state.text] });
        this.setState({ text: "" });
    };

    render() {
        return (
            <div id="container">
                <h1 id="title-js">Bienvenido a <em>React-DOM con Components</em></h1>
                <h2>Notas: {this.state.text}</h2>
                <div className="fooDiv">
                    <input
                        value={this.state.text}
                        onChange={ev => this.setState({
                            text: ev.target.value
                        })}
                    />
                    <button onClick={this.addCurrentNote}>Agregar</button>
                </div>
                {this.state.notes.map((note, i) => <Note key={i} text={note} />)}
            </div>
        );
    };
}

ReactDOM.render(<App
    text="Soy un text pasado por props"
    num='42'
    />, document.getElementById("app"));
