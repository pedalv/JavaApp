import React, { useState } from "react";
import "./gitbub.less";
import { UserProfileProps } from "./Card";
import CardList, { CardListProps } from "./CardList";
import Form from "./Form";

export type DisplayGithubProps = {
  title: string;
};

/*
class DisplayGithub extends React.Component<DisplayGithubProps, object> {

    state = {
        profiles: [],
    };

    addNewProfile = (profileData: UserProfileProps) => {
        this.setState((prevState: CardListProps) => ({
            profiles: [...prevState.profiles, profileData],
        }));
    };

    render() {
        return (
            <div>
                <div className="header">{this.props.title}</div>
                <Form onSubmit={this.addNewProfile} />
                <CardList profiles={this.state.profiles} />
            </div>
        );
    }
}
*/


const initialState : CardListProps = { profiles: [] };

const DisplayGithub = (props: DisplayGithubProps) => {

    const [state , setState] = useState(initialState);

    const addNewProfile = (profileData: UserProfileProps) => {
        setState((prevState: CardListProps) => ({
            profiles: [...prevState.profiles, profileData],
        }));
    };

    return (
        <div>
            <div className="header">{props.title}</div>
            <Form onSubmit={addNewProfile} />
            <CardList profiles={state.profiles} />
        </div>
    );
};

export default DisplayGithub
