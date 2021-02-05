import React, { FormEvent, useState } from "react";
import axios from "axios";
import { UserProfileProps } from "./Card";

export type FormProps = {
  onSubmit: (profiles: UserProfileProps) => void;
};

/*
class Form extends React.Component<FormProps, object> {
    state = {
        userName: ''
    };

    handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const resp = await axios.get(`https://api.github.com/users/${this.state.userName}`);
        this.props.onSubmit(resp.data);
        this.setState({ userName: '' });
    };

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <input
                    type="text"
                    value={this.state.userName}
                    onChange={event => this.setState({ userName: event.target.value })}
                    placeholder="GitHub username"
                    required
                />
                <button>Add card</button>
            </form>
        );
    }

}
 */

interface UsertypeType {
    [key: string]: string;
}

const initialState : UsertypeType = { userName: '' };

const Form = (props : FormProps) => {

    const [state , setState] = useState(initialState);

    const handleSubmit = async (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const resp = await axios.get(`https://api.github.com/users/${state.userName}`);
        props.onSubmit(resp.data);
        setState({ userName: '' });
    };

    return (
        <form onSubmit={handleSubmit}>
            <article>GitHub usernames: gaearon, sophiebits, sebmarkbage, bvaughn</article>
            <input
                type="text"
                value={state.userName}
                onChange={event => setState({ userName: event.target.value })}
                placeholder="GitHub username"
                required
            />
            <button>Add card</button>
        </form>
    );

};


export default Form;