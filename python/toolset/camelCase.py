def to_camel_case(snake_str):
    components = snake_str.split('_')
    return components[0] + ''.join(x.title() for x in components[1:])


input = """ convert_me_to_camel """
print(to_camel_case(input))
