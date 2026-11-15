# Валидация HTML
## TopFrame (topframe-group.com)

*Общее количество ошибок*: 14<br>
*Количество критичных ошибок*: 12<br>
*Самые частые типы ошибок*: <br>
- Незакрытые теги
- Использование лишних атрибутов<br>

*Наличие ошибок доступности*: Да (3 шт.)

***Распределение ошибок по приоритетам***:
**1. Высокий**
- Bad start tag in `div` in `noscript` in `head` <br>(Элементы `div` и `noscript` не могут находиться в `<head>`)<br>
- Stray end tag `noscript` <br>(Потерянный закрывающий тег)<br>
- Stray end tag `head` <br>(Потерянный закрывающий тег)<br>
- Start tag `body` seen but an element of the same type was already open <br>(Дублирование тега `<body>`)<br>
- End tag for `body` seen, but there were unclosed elements<br>(Закрытие `<body>` при незакрытых элементах)<br>
- Enclosed element `div`<br>(Незакрытый `<div>`)

**2. Средний**
- A document must not include both a `meta` element with an `http-equiv` attribute whose value is `content-type`, and a `meta` element with a `charset` attribute <br>(Конфликт meta-тегов (`http-equiv="content-type"` и `charset`). Нельзя использовать оба одновременно)
- A document must not include more than one `meta` element with its `name` attribute set to the value `description` <br>(Дублирование meta-тега `description`)
- Attribute `webkit-playinginline` not allowed on element `video` at this point (3) <br>(Недопустимый атрибут (встречается 3 раза))
- Bad value `video/mov;"` for attribute `type` on element `source`: Expected whitespace or a token character but saw `"` instead <br>(Синтаксическая ошибка в MIME-типе (лишняя точка с запятой))

**3. Низкий**
-The  `type`  attribute is unnecessary for JavaScript resources. (2)<br>(Избыточный атрибут `type="text/javascript"` (встречается 2 раза))