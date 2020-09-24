const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');


class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {user: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/user'}).done(response => {
            this.setState({user: response});
        });
    }

    render() {
        return (
            <UserList user={this.state.user}/>
        )
    }
}


class UserList extends React.Component{
    render() {
        const users = this.props.users.map(user =>
            <User key={user.id} user={user}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Tagline</th>
                    <th>Password</th>
                </tr>
                {users}
                </tbody>
            </table>
        )
    }
}

class User extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.user.id}</td>
                <td>{this.props.user.firstName}</td>
                <td>{this.props.user.lastName}</td>
                <td>{this.props.user.email}</td>
                <td>{this.props.user.tagLine}</td>
                <td>{this.props.user.pasword}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)