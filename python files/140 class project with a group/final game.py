import random



############################################################################################  difficulty        Brady Bierman
def difficulty():
    confirm = 0
    easy = "1: easy(keep items and levels on death)"
    medium = "2: medium(keep levels on death)"
    hard = "3: hard(lose everything on death)"
    while confirm != 1:
        confirm = 0
        print(" ")
        print("select game difficulty: ")
        print(easy)
        print(medium)
        print(hard)
        game_difficulty = int(input("enter a number: "))
        if game_difficulty == 1:
            print("you have selected: ")
            print(easy)
            while confirm != 1 and confirm != 2:
                confirm = int(input("1:confirm 2:change selection: "))
                if confirm != 1 and confirm != 2:
                    print("invalid selection")
            return game_difficulty
        elif game_difficulty == 2:
            print("you have selected: ")
            print(medium)
            while confirm != 1 and confirm != 2:
                confirm = int(input("1:confirm 2:change selection: "))
                if confirm != 1 and confirm != 2:
                    print("invalid selection")
                return game_difficulty
        elif game_difficulty == 3:
            print("you have selected: ")
            print(hard)
            while confirm != 1 and confirm != 2:
                confirm = int(input("1:confirm 2:change selection: "))
                if confirm != 1 and confirm != 2:
                    print("invalid selection")
                return game_difficulty
        else:
            print("invalid selection")



##########################################################################################################################    create item objects       Brady Bierman
class items():
    def __init__(self, name, damage_reduction, bonus_health, bonus_magic, bonus_strength, bonus_range, equipped, stored, found):
        self.name = name
        self.damage_reduction = damage_reduction
        self.health_boost = bonus_health
        self.magic_boost = bonus_magic
        self.strength_boost = bonus_strength
        self.range_boost = bonus_range
        self.equipped = equipped
        self.stored = stored
        self.found = found





########################################################################################################################    encounter menu      Brady Bierman
def encounter_menu():
    global exit_dungeon, next_room
    next_room = False
    encounter_action = 0
    use_potion_text = "1: use potion"
    equip_items_text = "2: equip items"
    next_room_text = "3: next room"
    leave_dungeon_text = "4: leave dungeon"
    while not next_room and not exit_dungeon:
        print(" ")
        print("select what you want to do:")
        print(use_potion_text)
        print(equip_items_text)
        print(next_room_text)
        print(leave_dungeon_text)
        encounter_action = int(input("enter a number: "))
        if encounter_action == 1:
            print(use_potion_text)
            player_class.inventory()
        elif encounter_action == 2:
            print(equip_items_text)
            player_class.equip_items()
        elif encounter_action == 3:
            print("you advance to the next room")
            next_room = True
            return next_room
        elif encounter_action == 4:
            print("you leave the dungeon unharmed")
            exit_dungeon = True
            return exit_dungeon
        else:
            print(" ")
            print("invalid selection")



####################################################################################################################    outside dungeon     Brady Bierman
def outside_dungeon():
    global exit_dungeon; found_items; player_class
    outside_dungeon_action = 0
    enter_dungeon_text = "1: enter the dungeon"
    item_storage_text = "2: access item storage"
    quit_text = "3: quit"
    while exit_dungeon == 1:
        print()
        print("what do you want to do while outside the dungeon?")
        print(enter_dungeon_text)
        print(item_storage_text)
        print(quit_text)
        outside_dungeon_action = int(input("enter a number: "))
        if outside_dungeon_action == 1:
            print()
            print("you return to the dungeon")
            exit_dungeon = 0
            return exit_dungeon
        elif outside_dungeon_action == 2:
            for i in found_items:
                store = 0
                if not i.equipped:
                    if not i.stored:
                        print()
                        print("would you like to store", i.name, "?")
                        while store != 1 and store != 2:
                            store = int(input("1: yes  2: no "))
                            if store == 1:
                                i.stored = True
                                print()
                                print("you have stored", i.name)  
                            elif store == 2:
                                i.stored = False
                                i.equipped = False
                                print()
                                print("you keep", i.name, "with you")
                            else:
                                print()
                                print("invalid selection")
                    else:
                        print()
                        print("would you like to retreive", i.name, "from storage?")
                        while store != 1 and store != 2:
                            store = int(input("1: yes  2: no "))
                            if store == 1:
                                i.stored = False
                                print()
                                print("you have retrieved", i.name)  
                            elif store == 2:
                                i.stored = True
                                print("you keep", i.name, "in storage")
                            else:
                                print()
                                print("invalid selection")
                else:
                    print("this item is equpped, please unequip it before storing it")
                    choice = int(input("would you like to unequip", i.name, "?"))
                    if choice == 1:
                        player_class.equip_items()
        elif outside_dungeon_action == 3:
            end_game = True
            return end_game
        else:
            print("invalid selection")




##############################################################################################################################################################      player      Angel Centeno

class Player:
    def __init__(self, health, max_health, max_magic, magic, strength, ranged, xp, lvl, total_health_boost, total_damage_reduction, total_strength_boost, total_magic_boost, total_range_boost, item_max, equip):
        self.health = health
        self.max_health = max_health
        self.max_magic = max_magic
        self.magic = magic
        self.strength = strength
        self.ranged = ranged
        self.xp = xp
        self.lvl = lvl
        self.total_health_boost = total_health_boost
        self.total_damage_reduction = total_damage_reduction
        self.total_strength_boost = total_strength_boost
        self.total_magic_boost = total_magic_boost
        self.total_range_boost = total_range_boost
        self.item_max = item_max
        self.equip = equip

    def reset(self):
        self.health = self.max_health
        self.magic = self.max_magic
        
    def take_damage(self, damage):
        damage = damage - self.total_damage_reduction
        if damage < 0:
            damage = 0
        self.health -= damage
        if self.health < 0:
            self.health = 0
        print(f"player took {damage} damage. Current health: {self.health}")

    def attack(self):
        attack = self.strength+(random.randint(0,5))
        print(f"player dealt {attack} damage.")
        return attack

    def magic_attack(self):
        if self.magic > 0:
            magic = self.magic
            self.magic -= 5
            print(f"player dealt {magic} damage.")
            print(self.magic, "mana remaining")
            return magic
        else:
            print('Not enough mana')
            return magic
           

    
    def ranged_attack(self):
        ranged = self.ranged+(random.randint(0,5))
        print(f"player dealt {ranged} damage.")
        return ranged

    def inventory(self):
        choice = int(input("what potion would you like to take? 1: health, 2: mana " ))
        potion = 10
        if(choice==1):
            if(self.health+potion > self.max_health):
                potion = self.max_health - self.health
                self.health += potion
                print('healed for ' + str(potion) + ' health is now ' + str(self.health))
            else:
                self.health += potion
                print('healed for ' + str(potion) + ' health is now ' + str(self.health))
        if(choice==2):
            if(self.magic+potion > self.max_magic):
                potion = self.max_magic - self.magic
                self.magic += potion
                print('Magic healed for ' + str(potion) + ' mana is now ' + str(self.magic))
            else:
                self.magic += potion
                print('Magic healed for ' + str(potion) + ' mana is now ' + str(self.magic))
    def lvlup(self):
        self.lvl += 1
        self.xp = 0
        print('You leveled up')
        skill= int(input('pick skill to level up 1:health 2:magic 3:strength 4:range '))
        if(skill == 1):
            self.max_health += 5
        if(skill == 2):
            self.max_magic += 5
        if(skill == 3):
            self.strength += 5
        if(skill == 4):
            self.ranged += 5
                
    def xpgain(self, ex):
        self.xp += ex
        if(self.xp >= 100):
            self.lvlup()
  
    def equip_items(self):
        global found_items
        finished = False
        while not finished:
            for i in found_items:
                if not i.stored:
                    if not i.equipped:
                        choice = int(input("would you like to equip " + i.name + "? 1:yes, 2: no "))
                        if choice == 1:
                            if self.equip < self.item_max:
                                self.total_damage_reduction += i.damage_reduction
                                self.total_health_boost += i.health_boost
                                self.total_magic_boost += i.magic_boost
                                self.total_strength_boost += i.strength_boost
                                self.total_range_boost += i.range_boost
                                i.equipped = True
                                self.equip += 1
                                self.bounses(1)
                                print(f"{i.name} equipped. Stats updated.")
                                
                            else:
                                print("please unequip another item first")
                    else:
                        choice = int(input("would you like to unequip " + i.name + "? 1:yes, 2: no "))
                        if choice == 1:
                            i.equipped = False
                            self.total_damage_reduction -= i.damage_reduction
                            self.total_health_boost -= i.health_boost
                            self.total_magic_boost -= i.magic_boost
                            self.total_strength_boost -= i.strength_boost
                            self.total_range_boost -= i.range_boost
                            self.equip -= 1
                            self.bounses(2)
                            print(f"{i.name} dequipped. Stats updated.")
            
            done = int(input("are you done equiping items? 1: yes, 2: no "))
            if done == 1:
                finished = True
            elif done == 2:
                finished = False


    def bounses(self, choice):
        if choice == 1:
            self.health += self.total_health_boost
            self.max_health += self.total_health_boost
            self.magic += self.total_magic_boost
            self.max_magic += self.total_magic_boost
            self.strength += self.total_strength_boost
            self.ranged += self.total_range_boost
        if choice == 2:
            self.health -= self.total_health_boost
            self.max_health -= self.total_health_boost
            self.magic -= self.total_magic_boost
            self.max_magic -= self.total_magic_boost
            self.strength -= self.total_strength_boost
            self.ranged -= self.total_range_boost



##############################################################################################################################################      outcome     Angel Centeno
def outcome():
    global game_difficulty, player_class, found_items, items_list
    if(player_class.health <= 0):
        print('player was defeated')
        print("your level was", str(player_class.lvl))
        over = int(input('Do you want to continue? 1: yes 2: no '))
        if(over == 1):
            game_difficulty = int(game_difficulty)
            if game_difficulty == 1:
                player_class.reset()
            if game_difficulty == 2:
                found_items = []
                player_class.reset()
            if game_difficulty == 3:
                found_items = []
                player_class = select
        if(over == 2):
            print('Game over')
            print("your level was", str(player_class.lvl))
            end = True
            return end

    else:
        print('You defeated ' + monster_spawned.name)
        print("you gained ", monster_spawned.xp, "xp!")
        player_class.xpgain(monster_spawned.xp)
        item_drop = random.randint(1,5)
        found = 0
        total = 0
        for i in found_items:
            found += 1
        for i in items_list:
            total += 1
        if item_drop == 1 and found != total:
            reward = True
            while reward:
                item_reward = random.randint(0, 8)
                if not items_list[item_reward].found:
                    found_items.append(items_list[item_reward])
                    items_list[item_reward].found = True
                    print("you found", items_list[item_reward].name, "!!")
                    reward = False

        
        choice = int(input('Do you want to countinue? 1: yes 2: no '))
        if(choice == 1):
            encounter_menu()
        if(choice == 2):
            print('Game over')
            print("your level was", str(player_class.lvl))





########################################################################################################################################        select      Angel Centeno
def select():
    player_class_select = int(input("select your class: 1: mage, 2: warrior, 3: archer "))
    if player_class_select == 1:
        mage = Player(80, 80, 20, 20, 8, 10, 0, 1, 0, 0, 0, 0, 0, 3, 0)
        print("you have chosen mage")
        return mage
    elif player_class_select == 2:
        warrior = Player(100, 100, 5, 5, 15, 5, 0, 1, 0, 0, 0, 0, 0, 3, 0)
        print("you have chosen warrior")
        return warrior
    elif player_class_select == 3:
        archer = Player(90, 90, 15, 15, 12, 15, 0, 1, 0, 0, 0, 0, 0, 3, 0)
        print("you have chosen archer")
        return archer
    

####################################################################################################################################        monster     Jaylin
class monster:
    def __init__(self, health, strength, xp, name, catch_phrase,):
        self. health = health
        self. strength = strength
        self. xp = xp
        self. name = name
        self. catch_phrase = catch_phrase


    def attack(self):
        rand = random.randint(0, 5)
        damage = self.strength + rand
        print("the ", self.name, "did ", damage)
        return damage



    def take_damage(self, damage):
        self.health -= damage
        if self.health <= 0:
            self.health = 0
            



               
def spawn_monster():
    spawn = random.randint(1, 4)
    if spawn == 1 or spawn == 2:
        print("you have encountered a Goblin")
        Goblin.health = 50
        return Goblin
    elif spawn == 3:
        print("you have encountered an Orc")
        Orc.health = 70
        return Orc
    elif spawn == 4:
        print("you have encountered a Dragon")
        Dragon.health = 120
        return Dragon


##############################################################################################################      initialization

end = False
items_list = []
found_items = []
exit_dungeon = False
next_room = False
end_game = False


Goblin = monster(50, 10, 5, "Goblin", "Encountered Goblin")
Orc = monster (70, 14, 10, "Orc", "Encountered Orc")
Dragon = monster (120, 20, 20, "Dragon", "Encountered mini boss") 


##############################################################################################################    making the items     Brady Bierman
item_1 = items("vital amulet grants: 5 damage reduction and 12 health", 5, 12, 0, 0, 0, False, False, False)
items_list.append(item_1)
item_2 = items("all-round grants: 5 magic, 5 strength, and 5 range", 0, 0, 5, 5, 5, False, False, False)
items_list.append(item_2)
item_3 = items("warrior's blade grants: 15 health and 10 strength", 0, 15, 0, 10, 0, False, False, False)
items_list.append(item_3)
item_4 = items("mage's staff grants: 4 damage reduction and 10 magic", 4, 0, 10, 0, 0, False, False, False)
items_list.append(item_4)
item_5 = items("hunter's bow grants: 5 damage reduction and 10 health", 5, 0, 0, 0, 10, False, False, False)
items_list.append(item_5)
item_6 = items("mage bow grants: 8 magic and 8 range", 0, 0, 8, 0, 8, False, False, False)
items_list.append(item_6)
item_7 = items("spell sword grants: 8 magic and 8 strength", 0, 0, 8, 8, 0, False, False, False)
items_list.append(item_7)
item_8 = items("heavy bow grants: 8 strength and 8 range", 0, 0, 0, 8, 8, False, False, False)
items_list.append(item_8)
item_9 = items("mithril chestplate grants: 10 damage reduction", 10, 0, 0, 0, 0, False, False, False)
items_list.append(item_9)



#####################################################################################################################################       main loop
while not end_game:
    end = False
    found_items = []
    exit_dungeon = False
    next_room = False
    
    game_difficulty = difficulty()
    player_class = select()
  

    while not end:
        encounter_menu()
        if next_room:
            monster_spawned = spawn_monster()
            while monster_spawned.health != 0 and player_class.health != 0:
                choice = int(input("what would you like to do? 1: melee attack, 2: magic attack, 3: ranged attack, 4: use a potion "))
                if choice == 1:
                    damage = player_class.attack()
                    monster_spawned.take_damage(damage)
                elif choice == 2:
                    damage = player_class.magic_attack()
                    monster_spawned.take_damage(damage)
                elif choice == 3:
                    damage = player_class.ranged_attack()
                    monster_spawned.take_damage(damage)
                elif choice == 4:
                    player_class.inventory()
                damage = monster_spawned.attack()
                player_class.take_damage(damage)
            end_run = outcome()
            if end_run:
                end = True

        elif exit_dungeon:
            end_game = outside_dungeon()
        if end_game:
            end = True
   


