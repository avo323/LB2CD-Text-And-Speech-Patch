;;; Sierra Script 1.0 - (do not remove this comment)
(script# 330)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use Blink)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm330 0
	Laura 2
	Steve 12
)

(local
	local0 =  1
)
(instance rm330 of LBRoom
	(properties
		noun 7
		picture 330
		horizon 125
		north 335
		south 250
		vanishingX 400
		vanishingY 78
	)
	
	(method (init)
		(proc958_0 128 1410 1411 330 331 213)
		(proc958_0 132 332 330 40)
		(proc958_0 129 415 410)
		(gEgo
			normalize: (if (gEgo wearingGown?) 831 else 830)
			init:
		)
		(switch gGNumber
			(north
				(gEgo posn: 158 146 signal: (| (gEgo signal?) $4000))
				(if
					(not
						(if (and (== global123 2) (proc0_10 8))
							(not (proc0_2 133))
						)
					)
					(gWrapSound number: 330 flags: 1 loop: 1 play:)
				)
				(if
					(and
						(== global123 2)
						(proc0_10 8)
						(not (proc0_2 133))
					)
					(steve init: loop: 1 setCycle: Walk)
					(gEgo setScale: 179)
					(global2 setScript: sKissAndHug)
				else
					(gGame handsOn:)
					(gEgo setScale: 179)
				)
			)
			(else 
				(gWrapSound number: 330 flags: 1 loop: 1 play:)
				(gEgo posn: 178 136)
				(gEgo setScale: 179)
				(if (gEgo wearingGown?)
					(taxi posn: 196 161 init: stopUpd:)
					(global2 setScript: sTaxiLeave)
					(gGame handsOff:)
				else
					(gGame handsOn:)
				)
			)
		)
		(if (> global123 1) (Palette palSET_INTENSITY 0 255 60))
		(super init:)
		(gGameMusic2 number: 333 flags: 1 loop: -1 play:)
		(self
			addObstacle:
				((Polygon new:)
					type: 3
					init:
						0
						143
						0
						169
						62
						162
						106
						158
						178
						152
						196
						144
						288
						140
						300
						137
						319
						137
						319
						127
						277
						128
						270
						134
						239
						134
						212
						116
						166
						116
						150
						116
						154
						131
						110
						140
						62
						144
						32
						139
						0
						141
					yourself:
				)
		)
		(larch init:)
		(lawn1 init:)
		(lawn2 init:)
		(car1 init:)
		(car2 init:)
		(clouds setOnMeCheck: 1 128 init:)
		(dome setOnMeCheck: 1 8 init:)
		(entrance setOnMeCheck: 1 32 init:)
		(bigWindow setOnMeCheck: 1 2 init:)
		(sidewalk setOnMeCheck: 1 4 init:)
		(steps setOnMeCheck: 1 16384 init:)
		(if (< global123 2) (taxi init: stopUpd:))
		(street setOnMeCheck: 1 64 init:)
		(fountain1 init: setCycle: Fwd)
		(fountain2 init: setCycle: Fwd)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_1 gEgo 256) (global2 setScript: sHitEdgeScreen))
		)
	)
	
	(method (dispose)
		(carSound dispose:)
		(gWrapSound fade: 0 30 12 1)
		(gGameMusic2 fade: 0 30 12 1)
		(super dispose: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if local0
					(gLb2Messager say: 7 1 1)
					(= local0 0)
				else
					(gLb2Messager say: 7 1 2)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance sHitEdgeScreen of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLb2Messager say: 4 3 0 0 self 91)
			)
			(1
				(if (> (gEgo heading?) 180)
					(gEgo setHeading: 90)
				else
					(gEgo setHeading: 270)
				)
				(gEgo setMotion: MoveFwd 10 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTaxiLeave of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(taxi setMotion: MoveTo 369 125 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInTaxi of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 146 151 self)
			)
			(1
				(carSound play:)
				(= ticks 30)
			)
			(2
				(gEgo setMotion: MoveTo 146 163 self)
			)
			(3 (gEgo hide:) (= cycles 2))
			(4 (global2 newRoom: 250))
		)
	)
)

(instance sKissAndHug of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 58 150 self)
			)
			(1
				(proc0_5 gEgo steve)
				(proc0_5 steve gEgo)
				(= seconds 4)
			)
			(2
				(gGame points: 1 133)
				(global2 picture: 780 setInset: closeUp self)
			)
			(3
				(gOldCast eachElementDo: #hide)
				(= cycles 2)
			)
			(4
				(global2 drawPic: 330)
				(Palette palSET_INTENSITY 0 255 60)
				(gOldCast eachElementDo: #show)
				(steve setLoop: 0)
				(gEgo setMotion: PolyPath 158 146 self)
			)
			(5
				(DrawPic 780 dpOPEN_FADEPALETTE)
				(gOldCast eachElementDo: #hide)
				(= cycles 2)
			)
			(6
				(Palette palSET_INTENSITY 0 255 100)
				(global2 newRoom: 350)
				(self dispose:)
			)
		)
	)
)

(instance sCloseUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(gWrapSound number: 332 flags: 1 loop: -1 play:)
				(gLb2Messager say: 6 0 0 0 self 330)
				(gGameMusic2 fade: 0 12 30 0)
			)
			(2
				(DrawPic 415 -32758)
				(gWrapSound number: 334 flags: 1 loop: 1 play:)
				(= seconds 4)
			)
			(3
				(DrawPic 410 -32758)
				(= ticks 30)
			)
			(4
				(gLb2Messager say: 12 0 0 0 self 330)
			)
			(5
				(gGameMusic2 fade: 127 12 30 0)
				(closeUp dispose:)
				(self dispose:)
			)
		)
	)
)

(instance taxi of Actor
	(properties
		x 139
		y 146
		noun 5
		view 213
		cel 2
		priority 15
		signal $4010
		moveSpeed 0
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (global2 setScript: sInTaxi))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance steve of Actor
	(properties
		x 156
		y 142
		view 331
		signal $4000
	)
	
	(method (doit)
		(= cel (gEgo cel?))
		(= x (- (gEgo x?) 2))
		(= y (- (gEgo y?) 4))
		(super doit: &rest)
	)
)

(instance fountain1 of Prop
	(properties
		x 77
		y 137
		noun 4
		view 330
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gLb2Messager say: 4 6 3))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance fountain2 of Prop
	(properties
		x 263
		y 126
		noun 4
		view 330
		loop 1
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gLb2Messager say: 4 6 3))
			(else  (super doVerb: theVerb))
		)
	)
)

;;;(instance steveLips of Prop ;;UNUSED
;;;	(properties
;;;		x 127
;;;		y 57
;;;		view 1410
;;;		loop 4
;;;		priority 15
;;;		signal $4000
;;;	)
;;;)
;;;
(instance Laura of Talker
	(properties
		x 0
		y 0
		view 1411
		loop 3
		disposeWhenDone 0
		talkWidth 250
		back 15
		textX 15
		textY 120
	)
	
	(method (init)
		(= font gFont)
		(super init: lauraBust lauraEyes lauraMouth &rest)
	)
)

(instance lauraBust of Prop
	(properties
		view 1411
		loop 1
	)
)

(instance lauraEyes of Prop
	(properties
		nsTop 63
		nsLeft 188
		view 1411
		loop 2
		signal $4000
	)
)

(instance lauraMouth of Prop
	(properties
		nsTop 73
		nsLeft 178
		view 1411
		signal $4000
	)
)

(instance Steve of Talker
	(properties
		x 0
		y 0
		view 1410
		loop 3
		disposeWhenDone 0
		talkWidth 250
		back 15
		textX 15
		textY 105
	)
	
	(method (init)
		(= font gFont)
		(super init: steveBust steveEyes steveMouth &rest)
	)
)

(instance steveBust of Prop
	(properties
		view 1410
		loop 1
	)
)

(instance steveEyes of Prop
	(properties
		nsTop 49
		nsLeft 140
		view 1410
		loop 2
		signal $4000
	)
)

(instance steveMouth of Prop
	(properties
		nsTop 57
		nsLeft 127
		view 1410
		signal $4000
	)
)

(instance lawn1 of Feature
	(properties
		x 27
		y 130
		noun 8
		nsTop 127
		nsBottom 134
		nsRight 54
		sightAngle 40
	)
)

(instance lawn2 of Feature
	(properties
		x 297
		y 122
		noun 8
		nsTop 119
		nsLeft 275
		nsBottom 125
		nsRight 319
		sightAngle 40
	)
)

(instance car1 of Feature
	(properties
		y 3
		noun 2
		nsTop 148
		nsBottom 174
		nsRight 69
	)
)

(instance car2 of Feature
	(properties
		y 3
		noun 2
		nsTop 126
		nsLeft 204
		nsBottom 143
		nsRight 276
	)
)

(instance larch of Feature
	(properties
		y 3
		noun 3
		nsTop 78
		nsLeft 44
		nsBottom 110
		nsRight 92
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gLb2Messager say: 3 6 3))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance clouds of Feature
	(properties
		y 3
		noun 11
	)
)

(instance dome of Feature
	(properties
		y 3
		noun 13
	)
)

(instance entrance of Feature
	(properties
		y 3
		noun 14
	)
)

(instance bigWindow of Feature
	(properties
		y 3
		noun 15
	)
)

(instance sidewalk of Feature
	(properties
		y 3
		noun 1
	)
)

(instance steps of Feature
	(properties
		y 3
		noun 9
	)
)

(instance street of Feature
	(properties
		y 3
		noun 10
	)
)

(instance closeUp of Inset
	(properties
		picture 410
		style $800a
		hideTheCast 1
	)
	
	(method (init)
		(super init: &rest)
		(self setScript: sCloseUp)
	)
)

(instance carSound of Sound
	(properties
		flags $0001
		number 40
	)
)
