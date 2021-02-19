import { useEffect, useState } from 'react'
import fetchJson from '../../utils/fetch'
import { Table, Form } from 'react-bootstrap'


export default function Journal(props) {

    const [ journal, setJournal ] = useState([])
    const [ groups, setGroups ] = useState([])
    const [ group, setGroup] = useState("")
    useEffect(() => {
        fetchJson("http://localhost:8080/journal")
                   .then((data) => setJournal(data))
        fetchJson("http://localhost:8080/group")
                   .then((data) => setGroups(data))
    }, [])

    useEffect(() => {
        fetchJson(`http://localhost:8080/journal?group=${group}`)
        .then((data) => setJournal(data))
    }, [group])

    return (
        <div>
        <Form>
            <Form.Group controlId="groupSelect">
                <Form.Label>Выбор группы</Form.Label>
                <Form.Control as="select" onChange = {(e) => setGroup(e.target.value)}>
                {
                    groups.map((group, i) => {
                        return (
                            <option key={group.id}>{group.name}</option>
                        )
                })}
                </Form.Control>
            </Form.Group>
        </Form>
        <Table bordered>
            <thead>
                <tr>
                    <th>#</th>
                    <th>ФИО</th>
                    <th>Группа</th>
                    <th>Тип аттестации</th>
                    <th>Количество пересдач</th>
                    <th>Предмет</th>
                    <th>Оценка</th>
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
                            <td>{row.student.group.name}</td>
                            <td>{row.studyPlan.examType.type}</td>
                            <td>{row.count}</td>
                            <td>{row.studyPlan.subject.short_name}</td>
                            <td>{row.mark.name}</td>
                        </tr>
                    )
                })}
            </tbody>
        </Table>
        </div>
    )
}