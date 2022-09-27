export default class KanbanAPI {
    static getItems(columnID) {
        const column = read().find(column => column.id == columnID);

        if (!column){
            return [];
        }

        return column.items;
    }
    static insertItem(columnID, content) {
        const data = read();
        const column = data.find(column => column.id == columnID);
        const item = {
            id: Math.floor(Math.random() * 1000000),
            // == content: content
            content
        };

        if (!column) {
            throw new Error("no columns bozo");
        }

        column.items.push(item);
        save(data);

        return item;
    }
    static updateItem(itemID, newProps) {
        const data = read();
        const [item, curColumn] = (() => {
            for (const column of data) {
                const item = column.items.find(item => item.id == itemID);

                if (item) {
                    return [item, column];
                }
            }
        })()

        if (!item) {
            throw new Error("no item bozo");
        }

        item.content = newProps.content === undefined ? item.content : newProps.content;

        // update column and positiion
        if (
            newProps.columnID !== undefined
            && newProps.position !== undefined
        ) {
            const newColumn = data.find(column => column.id == newProps.columnID);

            console.log(newColumn);

            if (!newColumn) {
                throw new Error("no column bozo");
            }

            // curColumn.items = curColumn.items.filter(item => item.id != itemID);
            // newColumn.items.splice(newProps.position, 0, item);
        }
    }
}

function read() {
    const json = localStorage.getItem('kanban-data');

    if (!json){
        return [
            {
                id: 1,
                items: []
            },
            {
                id: 2,
                items: []
            },
            {
                id: 3,
                items: []
            },
        ];
    }

    return JSON.parse(json);
}

function save(data) {
    localStorage.setItem('kanbanData', JSON.stringify(data));
}
