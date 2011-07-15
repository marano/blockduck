def run_all_tests
  cmd = "cake midje"
  puts(cmd)
  result = IO.popen(cmd)
  notify(result)
end

watch( '^src.*/.*\.clj') { |m| run_all_tests }
watch( '^test.*/.*\.clj') { |m| run_all_tests }

def notify(result)
  messages = []
  messages[0] = result.readline
  if (messages[0] =~ /All claimed facts [(]\d[)] have been confirmed./)
    system("notify-send -t 4000 -i gtk-add Uau! \"Test is passing\"")
  else
    found_result = false
    crashed = false
    while !found_result && !crashed do
      begin
        messages << result.readline
      rescue EOFError
        crashed = true
        break;
      end
      if messages.last =~ /FAILURE: (\d) fact was not confirmed. [(]But (\d) were.[)]/
        found_result = true
      end
    end
    if crashed
      system("notify-send -t 4000 -i gtk-remove \"OMG!!!!!!!!\" \"Something is fucked up!\"")
    elsif found_result
      system("notify-send -t 4000 -i gtk-remove \"Oh nooo\" \"Only #{$1} fact#{$1.to_i > 1 ? "s" : ""} of #{$1.to_i + $2.to_i} were confirmed\"")
    end
  end
  puts
  puts
  messages.each { |m| puts m }
end

Signal.trap('QUIT') do
  puts "Veryfying all facts ..."
  run_all_tests
end

Signal.trap 'INT' do
  if @interrupted then
    @wants_to_quit = true
    abort("\n")
  else
    puts "Do it again to stop it!"
    @interrupted = true
    Kernel.sleep 1.5
    run_all_tests
  end
end
