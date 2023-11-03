import React from "react";
import Card, { UserProfileProps } from "./Card";

export interface CardListProps {
  profiles: UserProfileProps[];
}

const CardList = (props: CardListProps) => (
    <div>
        {props.profiles.map((profile) => (
            <Card key={profile.id} {...profile} />
        ))}
    </div>
);

export default CardList;