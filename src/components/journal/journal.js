import { useEffect, useState } from 'react'
import fetchJson from '../../utils/fetch'
import { Navbar, Nav, Dropdown, Tabs, Table, Tab} from 'react-bootstrap'


export default function Journal(props) {

    const [ journal, setJournal ] = useState([])

    useEffect( () => {
        fetchJson("http://localhost:8080/journal")
        .then((data) => setJournal(data))
    }, [])
    return (
        <Table bordered>
            <thead>
                <tr>
                    <th>#</th>
                    <th>ФИО</th>
                    <th>ПрИС</th>
                    <th>СИИ</th>
                </tr>
            </thead>
            <tbody>
                {journal.map((row, i) => {
                    const student = row.student
                    const studentName = `${student.surname} ${student.name} ${student.secondName}`
                    return (
                        <tr key={row.id}>
                            <td>{i + 1}</td>
                            <td>{studentName}</td>
                            <td>{row.mark.value}</td>
                            <td>{row.mark.id}</td>
                        </tr>
                    )
                })}
            </tbody>
        </Table>
    )
}