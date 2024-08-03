pub fn isPangram(str: []const u8) bool {
    var stats = [_]u8{0} ** 26;

    for(str) |char| {
        switch(char) {
            'a'...'z' => stats[char - 'a'] = 1,
            'A'...'Z' => stats[char - 'A'] = 1,
            else => {continue;},
        }

        var total: u8 = 0;
        for (stats) |s| {
            total += s;
        }

        if(total == 26){
            return true;
        }
    }

    return false;

}
